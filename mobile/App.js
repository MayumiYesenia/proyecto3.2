import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import { REACT_APP_BACKEND_URL } from '@env';
import React from 'react';
import Navigation from './screens/Navigation';

  export default function App() {
    return (
      <Navigation/>
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