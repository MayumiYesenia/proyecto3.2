// HomeScreen.js
import React, { useEffect, useState } from 'react';
import { View, Text, StyleSheet, Image, TouchableOpacity, TextInput } from 'react-native';
import axios from 'axios';
import { REACT_APP_BACKEND_URL } from '@env';

const HomeScreen = () => {
    const [originalData, setOriginalData] = useState(null);
    const [data, setData] = useState(null);
    const [currentPage, setCurrentPage] = useState(1);
    const [searchText, setSearchText] = useState('');

    useEffect(() => {
    const fetchData = async () => {
        try {
        const lugares = REACT_APP_BACKEND_URL + "lugares";
        console.log('URL del backend:', lugares);
        const response = await axios.get(lugares);
        console.log('Response from the backend:', response.data);
        setData(response.data);
        setOriginalData(response.data);
        } catch (error) {
        console.error('Error:', error);
        }
    };

    fetchData();
    }, []);

    const itemsPerPage = 3;
    const paginate = (array, pageSize, pageNumber) => {
    return array.slice((pageNumber - 1) * pageSize, pageNumber * pageSize);
    };

  // Función para manejar el cambio de página
    const handlePageChange = (page) => {
    setCurrentPage(page);
    };

    const handleSearch = () => {
        // Filtrar los resultados basados en el nombre
        const filteredData = originalData.filter((element) =>
          element.nombre.toLowerCase().includes(searchText.toLowerCase())
        );
        setData(filteredData);
        setCurrentPage(1);  // Restablece la página actual después de la búsqueda
      };

        return (
            <View style={styles.container}>
              <View style={styles.searchContainer}>
                <TextInput
                  style={styles.searchInput}
                  placeholder="Search by name..."
                  value={searchText}
                  onChangeText={(text) => setSearchText(text)}
                />
                <TouchableOpacity style={styles.searchButton} onPress={handleSearch}>
                  <Text>Search</Text>
                </TouchableOpacity>
              </View>
              <Text>Welcome to the Home Screen!</Text>
              {data && (
                <View style={styles.imageContainer}>
                  <Text>Data from the backend:</Text>
                  {paginate(data, itemsPerPage, currentPage).map((element, index) => (
                    <View key={index} style={styles.imageRow}>
                      {typeof element.fotos === 'string' ? (
                        <Image style={styles.image} source={{ uri: element.fotos }} />
                      ) : (
                        <View style={styles.errorContainer}>
                          <Text style={styles.errorText}>Invalid Image URL</Text>
                        </View>
                      )}
                    </View>
                  ))}
            <View style={styles.paginationContainer}>
            <TouchableOpacity
                style={styles.paginationButton}
                onPress={() => handlePageChange(1)}
                disabled={currentPage === 1}
            >
                <Text>First</Text>
            </TouchableOpacity>
            <TouchableOpacity
                style={styles.paginationButton}
                onPress={() => handlePageChange(currentPage - 1)}
                disabled={currentPage === 1}
            >
                <Text>Previous</Text>
            </TouchableOpacity>
            <Text>Page {currentPage}</Text>
            <TouchableOpacity
                style={styles.paginationButton}
                onPress={() => handlePageChange(currentPage + 1)}
              disabled={currentPage * itemsPerPage >= data.length}
            >
                <Text>Next</Text>
            </TouchableOpacity>
            </View>
        </View>
        )}
    </View>
    );
};

const styles = StyleSheet.create({
    container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    },
    imageContainer: {
    alignItems: 'center',
    justifyContent: 'center',
    },
    imageRow: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'center',
    marginVertical: 5,
    },
    image: {
    width: 100,
    height: 100,
    margin: 5,
    },
    paginationContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'center',
    marginTop: 10,
    },
    paginationButton: {
    padding: 10,
    marginHorizontal: 5,
    backgroundColor: '#eee',
    borderRadius: 5,
    },
    searchContainer: {
        flexDirection: 'row',
        justifyContent: 'flex-end',
        margin: 10,
        alignItems: 'center',
      },
      searchInput: {
        height: 40,
        borderColor: 'gray',
        borderWidth: 1,
        marginRight: 10,
        padding: 5,
        flex: 1,
      },
      searchButton: {
        padding: 10,
        backgroundColor: '#eee',
        borderRadius: 5,
      },
});

export default HomeScreen;
