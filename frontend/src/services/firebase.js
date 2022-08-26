import { initializeApp } from 'firebase/app';

import { getStorage } from "firebase/storage";

const firebaseConfig = {
  apiKey: "AIzaSyCEDojcinHLuldVIqF3D99HvXCnCDbU9ak",
  authDomain: "fir-react-thegoodseeds.firebaseapp.com",
  projectId: "fir-react-thegoodseeds",
  storageBucket: "fir-react-thegoodseeds.appspot.com",
  messagingSenderId: "513840110762",
  appId: "1:513840110762:web:fdfd56e4319e67c9a084d3"
};


export const app = initializeApp(firebaseConfig);

export const storage = getStorage(app);


