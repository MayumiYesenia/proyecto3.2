const axios = require('axios');
const apiKey = 'AIzaSyDRf_LfTqh1MJ4wET-ATwCLAJ30EkJd8Og';
const searchQuery = 'Veterinaria Barranco';
const apiUrl = `https://maps.googleapis.com/maps/api/place/textsearch/json?query=${searchQuery}&key=${apiKey}`;

function getPhotoUrl(photoReference) {
  if (!photoReference) {
    return null;
  }
  const googleMapsPhotoUrl = 'https://maps.googleapis.com/maps/api/place/photo';
  const maxWidth = 400;
  return `${googleMapsPhotoUrl}?maxwidth=${maxWidth}&photo_reference=${photoReference}&key=${apiKey}`;
}

function getPhotoReference(photoReference) {
  return photoReference ? photoReference : null;
}

function convertirFormatoHora(horaMilitar) {
  const horas = horaMilitar.substring(0, 2);
  const minutos = horaMilitar.substring(2);
  const hora12 = `${(horas % 12) || 12}:${minutos} ${horas < 12 ? 'AM' : 'PM'}`;
  return hora12;
}

async function main() {
  try {
    const response = await axios.get(apiUrl);
    const data = response.data;

    if (data.status === 'OK') {
      for (const result of data.results) {
        const name = result.name;
        const placeId = result.place_id;
        const detailsUrl = `https://maps.googleapis.com/maps/api/place/details/json?place_id=${placeId}&fields=opening_hours,formatted_phone_number&key=${apiKey}`;
        const detailsResponse = await axios.get(detailsUrl);
        const detailsData = detailsResponse.data.result;
        const phone = detailsData.formatted_phone_number || 'No disponible';
        const address = result.formatted_address || null;
        const rating = result.rating || null;
        const photoReference = result.photos && result.photos[0] ? result.photos[0].photo_reference : null;
        const business_status = result.business_status || null;
        const photoReferencePart = getPhotoReference(photoReference);
        const photoUrl = getPhotoUrl(photoReference);

        if (detailsData.opening_hours && detailsData.opening_hours.periods) {
          const openingHours = detailsData.opening_hours.periods.map(period => {
            const openTime = period.open.time;
            const closeTime = period.close ? period.close.time : '00:00'; // Si no hay hora de cierre, establecer como 00:00

            
            if (openTime === '00:00' && closeTime === '00:00') {
              return 'Abierto todo el día';
            }

            return `${convertirFormatoHora(openTime)} - ${convertirFormatoHora(closeTime)}`;
          });

          console.log('Horario de atención:');
          openingHours.forEach((hours, index) => {
            const dayOfWeek = ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'][index];
            console.log(`${dayOfWeek}: ${hours}`);
          });

          const openingHoursJson = JSON.stringify(openingHours);
          console.log('foto:', photoReferencePart);
          console.log('nombre:', name);
          console.log('direccion:', address);
          console.log('rating:', rating);
          console.log('foto:', photoUrl);
          console.log('estado:', business_status);
          console.log('openingHours:', openingHoursJson);
          console.log('Número de teléfono: ' + phone);
          const latitude = result.geometry.location.lat;
        }
        else {
          console.error('No se encontró información de horarios para este lugar.');
        }
      }
    } else {
      console.error('Error en la solicitud de búsqueda de lugares:', data.status);
    }
  } catch (error) {
    console.error('Error en la solicitud:', error);
  }
}

main();
