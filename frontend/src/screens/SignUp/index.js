import React, { useState,useCallback } from "react";
import axios from 'axios';

import Input from "../../components/InputLogin";
import Button from "../../components/ButtonLogin";
import * as C from "../SignIn/styles";
import { Link, useNavigate } from "react-router-dom";
import useAuth from "../../hooks/useAuth";

import * as Yup from 'yup';
import {useForm} from 'react-hook-form'
import { yupResolver } from '@hookform/resolvers/yup'
import logo from '../../assets/logo.jpeg';

export const SignUp = () => {
  const [errorGlobal, setErrorGlobal] = useState("");

   const api = axios.create({
  baseURL: 'http://localhost:8080',
  headers: {
    Application:'Access-Control-Allow-Origin'
  }

});

  const navigate = useNavigate();

  const { signup } = useAuth();

  const sendRegisterToApi = useCallback(
    async (dataRegister) => {
      try {

    const { userName, email, password } = dataRegister 

        await api.post('/registration', {
          userName, email, password
        }).then((data) => {
          console.log(data)
        })

       alert('Post feito com sucesso!')
      } catch (error) {
       alert('Erro na requisição.')

      }
    },
    []
  );

  const handleSignup = (userName, email, password) => {
          //METODO PARA REQUISICAO DO DO REGISter  --- /auth

          alert(userName)
          

          return

    // if ( !name | !email | !password) {
    //   return;
    // } 

    // const res = signup(name, email, password);
    // if (res) {
    //   setErrorGlobal(res);
    //   return;
    // }

    // alert("Usuário cadastrado com sucesso!");
    // navigate("/");
  };


  const registerUserFormSchema = Yup.object().shape({
    userName: Yup.string().required(
      'name is required.'
    ),
    email: Yup.string().required(
      'email is required.'
    ),
    password: Yup.string().required(
      'password is required.'
    ), 
  })

  const { 
    register, 
  handleSubmit,
  watch,
   formState: {errors}
   } = useForm(
    {resolver: yupResolver(registerUserFormSchema)}
   )

const submitForm = (data) => {
  // console.log(data)
  sendRegisterToApi(data)

  // handleSignup(data.userName, data.email, data.password)
}

  return (
    <C.Container>
      <C.Label>THE GOOD SEEDS</C.Label>
      <img src={logo}  style={{ width:100, height:100 }}  />

      <C.Content>
     
        
      <form onSubmit={handleSubmit(submitForm)} >

      <label htmlFor="name">name</label>
<input
id="userName"
type="name"
placeholder="Your Name"
{...register('userName')}
name='userName'
/>
{errors.userName && <span>{errors.userName?.message}</span> }

<label htmlFor="email">email</label>
<input
id="email"
type="email"
placeholder="Your E-mail"
{...register('email')}
name='email'
/>
{errors.email && <span>{errors.email?.message}</span> }

<label htmlFor="password">password</label>
<input
id="password"
type="password"
placeholder="Your password"
{...register('password')}
name='password'
/>
{errors.password && <span>{errors.password?.message}</span> }

<span>{errorGlobal}</span>
<div style={{ padding:12, width:'100%'}} >
<Button Text="Register" Type="submit"   />

</div>


<C.LabelSignup>
Já tem uma conta?
  <C.Strong>
    <Link to="/">&nbsp;Entre</Link>
  </C.Strong>

</C.LabelSignup>

</form> 
     
      </C.Content>
    </C.Container>
  );
};
