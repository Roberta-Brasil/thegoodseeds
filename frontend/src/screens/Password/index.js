import React, { useState } from "react";
import Input from "../../components/InputLogin";
import Button from "../../components/ButtonLogin";
import * as C from "../SignIn/styles";
import { Link, useNavigate } from "react-router-dom";
import useAuth from "../../hooks/useAuth";

import * as Yup from 'yup';
import {useForm} from 'react-hook-form'
import { yupResolver } from '@hookform/resolvers/yup'
import logo from '../../assets/logo.jpeg';

export const Password = () => {
  const { signin } = useAuth();
  const [errorGlobal, setErrorGlobal] = useState("");

  const navigate = useNavigate();


  // const handleLogin = () => {
  //   //METODO PARA REQUISICAO DO DO LOGIN  --- /auth

  //   if (!email | !senha) {
  //     setError("Digite seu email");
  //     return;
  //   }

  //   const res = signin(email, senha);

  //   if (res) {
  //     setError(res);
  //     return;
  //   }

  //   navigate("/dashboard");
  // };

  
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

const submitForm = (data) => {
  console.log(data)

  // handleSignup(data.name, data.email, data.password)
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
