import React, { useState } from "react";
import Button from "../../components/ButtonLogin";
import * as C from "../SignIn/styles";
import { Link } from "react-router-dom";
import axios from 'axios';

import * as Yup from 'yup';
import {useForm} from 'react-hook-form'
import { yupResolver } from '@hookform/resolvers/yup'
import logo from '../../assets/logo.jpeg';
import { url } from "../../services/url";

export const Password = () => {
  const [errorGlobal, setErrorGlobal] = useState("");
  
  const registerUserFormSchema = Yup.object().shape({
    password: Yup.string().required(
      'password é obrigatório.'
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

   async function tryResetPassword(data) {
    const {password}= data

    const newApi = axios.create( {
      baseURL: url,
      headers: {
        Application:'Access-Control-Allow-Origin',
      }})

      await newApi.post(`/forgot-password`, {
        password,
      })
      .then((res) => {
        console.log(res)

      }).catch((error) => {
        console.log(error)
      })
  
  }


const submitForm = async (data) => {

  try {
    await tryResetPassword(data);

  } catch (error) {
    console.log(error)
    alert('ERROR!',error)
  }

}

  return (
    <C.Container>
      <C.Label>THE GOOD SEEDS</C.Label>
      <img src={logo}  style={{ width:100, height:100 }}  />

      <C.Content>
        
      <form onSubmit={handleSubmit(submitForm)} >

<label htmlFor="password">password</label>
<input
id="password"
type="password"
placeholder="Your password"
minLength="8" 
pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^0-9a-zA-Z]).{8,26}$"
title="Digite uma senha com 8 letras, 1 maiúscula e 1 caractére especial."
x-moz-errormessage="Digite uma senha com 8 letras, 1 maiúscula e 1 caractére especial."
{...register('password')}
name='password'
/>
{errors.password && <span>{errors.password?.message}</span> }

<span>{errorGlobal}</span>
<div style={{ padding:12, width:'100%'}} >

<Button Text="Reset" Type="submit"   />
</div>


<C.LabelSignup>
Lembra sua senha?
  <C.Strong>
    <Link to="/">&nbsp;Voltar</Link>
  </C.Strong>

</C.LabelSignup>

</form> 

      </C.Content>
    </C.Container>
  );
};
