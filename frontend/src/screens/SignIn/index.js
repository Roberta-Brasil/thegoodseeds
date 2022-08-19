import React, { useRef, useState, useCallback } from "react";
import Input from "../../components/InputLogin";
import Button from "../../components/ButtonLogin";
import * as C from "./styles";
import { Link, useNavigate } from "react-router-dom";
import useAuth from "../../hooks/useAuth";
// import { Form } from "@unform/web";

import * as Yup from 'yup';
import {useForm} from 'react-hook-form'
import { yupResolver } from '@hookform/resolvers/yup'
import logo from '../../assets/logo.jpeg';



export const SignIn = () => {
  const api = "localhost.com"
  const { signin } = useAuth();
  const navigate = useNavigate();

  // const [email, setEmail] = useState("");
  // const [senha, setSenha] = useState("");
  const [errorGlobal, setErrorGlobal] = useState("");

  const handleLogin = (email, senha) => {

    const res = signin(email, senha);

    if (res) {
      setErrorGlobal(res);
      return;
    }

    navigate("/dashboard");
  };

  const loginUserFormSchema = Yup.object().shape({
    email: Yup.string().required(
      'email é obrigatório.'
    ),
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
      {resolver: yupResolver(loginUserFormSchema)}
     )

  const submitForm = (data) => {
    console.log(data)

    handleLogin(data.email, data.password)
  }

  return (
    <C.Container>
      <C.Label>THE GOOD SEEDS</C.Label>
      <img src={logo}  style={{ width:100, height:100 }}  />
      <C.Content>

        <form onSubmit={handleSubmit(submitForm)} >

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
        <Button Text="Entrar" Type="submit"   />
        </div>

        <C.LabelSignup>
          Não tem uma conta?
          <C.Strong>
            <Link to="/sign-up">&nbsp;Registre-se</Link>
          </C.Strong>

        </C.LabelSignup>

        <C.LabelSignup>
          Esqueceu sua
          <C.Strong>
            <Link to="/password">&nbsp;Senha?</Link>
          </C.Strong>

        </C.LabelSignup>

        </form> 

      </C.Content>
    </C.Container>
  );
};
