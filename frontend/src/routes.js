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

import { WishList } from './screens/WishList';

export const AppRoute = () => {

  const Private = ({ Item }) => {
    const { signed } = useAuth();

    return signed > 0
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
        <Route exact path="/wishlist" element={<Private Item={WishList} />} />
        <Route path="/" element={<SignIn />} />
        <Route exact path="/password" element={<Password />} />
        <Route exact path="/sign-up" element={<SignUp />} />
        <Route path="*" element={<SignIn />} />
      </Routes>
    </Router>
  );
}
