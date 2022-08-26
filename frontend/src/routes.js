import React from 'react';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import { Navbar } from './components/Navbar';
import { Main } from './components/Main';
import useAuth from './hooks/useAuth'

import { Dashboard } from './screens/Dashboard';
import { MySeeds } from './screens/MySeeds';
import { SignUp } from './screens/SignUp';
import { SignIn } from './screens/SignIn';
import { Password } from './screens/Password';

export const AppRoute = () => {

  const Private = ({ Item }) => {
    const {  token } = useAuth();

    return token
      ? (<>
        <Navbar />

        <Main>
          <Item />
        </Main>
      </>)

      : <SignIn />;
  };


  return (
    <Router>
      <Routes>
        <Route exact path="/dashboard" element={<Private Item={Dashboard} />} />
        <Route exact path="/my-seeds" element={<Private Item={MySeeds} />} />
        <Route path="/" element={<SignIn />} />
        <Route exact path="/password" element={<Password />} />
        <Route exact path="/sign-up" element={<SignUp />} />
        <Route path="*" element={<SignIn />} />
      </Routes>
    </Router>
  );
}
