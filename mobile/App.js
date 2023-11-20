import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import { REACT_APP_BACKEND_URL } from '@env';
import React from 'react';
import HomeScreen from './home';


  export default function App() {
    return (
      <HomeScreen />
    );
  }

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
