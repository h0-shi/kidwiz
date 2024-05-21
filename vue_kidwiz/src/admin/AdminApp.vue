<template>
    <component :is="$route.meta.layout || 'div'">
      <router-view></router-view>
    </component>
  </template>
  
  <script>
  export default {
    name: 'AdminApp',
  };
  </script>
  
  <style>
    
  </style>
  