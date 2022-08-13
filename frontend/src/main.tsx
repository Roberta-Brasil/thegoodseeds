import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import './index.css'


// this renders the information on the webbrowser
ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
)
