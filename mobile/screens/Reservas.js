import React, { useState } from "react";
import { Button, View, StyleSheet, TextInput, ScrollView } from "react-native";
import axios from "axios";

const AddReservationScreen = () => {
  const initialState = {
    nombre: "",
    telefono: "",
    fechainicio: "",
    fechaFin: "",  // Añadido campo fechaFin
    formapago: "", // Añadido campo formapago
    // Puedes añadir más campos según sea necesario
  };

  const [reservation, setReservation] = useState(initialState);

  const handleChangeText = (value, name) => {
    setReservation({ ...reservation, [name]: value });
  };

  const saveNewReservation = async () => {
    if (
      reservation.nombre === "" ||
      reservation.telefono === "" ||
      reservation.fechainicio === "" ||
      reservation.fechaFin === "" ||
      reservation.formapago === ""
    ) {
      alert("Por favor, complete todos los campos");
    } else {
      try {
        const response = await axios.post("https://proyecto-backend-production-b20c.up.railway.app/reservas", reservation);
        console.log("Respuesta de la API:", response.data);

        // Puedes hacer algo con la respuesta si es necesario

        // Restablecer el estado después de enviar la solicitud
        setReservation(initialState);
      } catch (error) {
        console.error("Error al enviar la solicitud:", error);
      }
    }
  };

  return (
    <ScrollView style={styles.container}>
      {/* Nombre Input */}
      <View style={styles.inputGroup}>
        <TextInput
          placeholder="Nombre"
          onChangeText={(value) => handleChangeText(value, "nombre")}
          value={reservation.nombre}
        />
      </View>

      {/* Teléfono Input */}
      <View style={styles.inputGroup}>
        <TextInput
          placeholder="Teléfono"
          onChangeText={(value) => handleChangeText(value, "telefono")}
          value={reservation.telefono}
        />
      </View>

      {/* Fecha Inicio Input */}
      <View style={styles.inputGroup}>
        <TextInput
          placeholder="Fecha de Inicio"
          onChangeText={(value) => handleChangeText(value, "fechainicio")}
          value={reservation.fechainicio}
        />
      </View>

      {/* Fecha Fin Input */}
      <View style={styles.inputGroup}>
        <TextInput
          placeholder="Fecha de Fin"
          onChangeText={(value) => handleChangeText(value, "fechaFin")}
          value={reservation.fechaFin}
        />
      </View>

      {/* Forma de Pago Input */}
      <View style={styles.inputGroup}>
        <TextInput
          placeholder="Forma de Pago"
          onChangeText={(value) => handleChangeText(value, "formapago")}
          value={reservation.formapago}
        />
      </View>

      {/* Puedes agregar más campos según sea necesario */}
      
      <View style={styles.button}>
        <Button title="Guardar Reserva" onPress={() => saveNewReservation()} />
      </View>
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 35,
  },
  inputGroup: {
    flex: 1,
    padding: 0,
    marginBottom: 15,
    borderBottomWidth: 1,
    borderBottomColor: "#cccccc",
  },
  button: {
    marginTop: 15,
  },
});

export default AddReservationScreen;