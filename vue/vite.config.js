// vite.config.js
import { resolve } from 'path';
import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';

export default defineConfig({
  plugins: [vue()],
  build: {
    outDir: 'src/main/resources/static/dist',
    rollupOptions: {
      input: resolve(__dirname, 'src/main/javascript/index.js'),
      output: {
        // Define a single output file
        entryFileNames: 'main.js', //  Customize if needed
        chunkFileNames: 'chunks/[name].[hash].js', // Chunk output
        assetFileNames: '[name].[hash].[ext]', // Asset output
      }// Entry point
    }
  },

});