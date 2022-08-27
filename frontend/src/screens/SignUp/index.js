import React, { useState } from "react";
import Button from "../../components/ButtonLogin";
import * as C from "../SignIn/styles";
import { Link, useNavigate } from "react-router-dom";
import * as Yup from 'yup';
import {useForm} from 'react-hook-form'
import { yupResolver } from '@hookform/resolvers/yup'
import logo from '../../assets/logo.jpeg';
import axios from 'axios';
import { url } from "../../services/url";
import { TailSpin } from "react-loader-spinner";

export const SignUp = () => {
  const navigate = useNavigate();
  const [errorGlobal, setErrorGlobal] = useState("");
  const [loadingScreen, setLoadingScreen] = useState(false);

  

  async function tryRegisterUser(data) {

    setLoadingScreen(true)

    const {
      userName,
      email,
      password,
    }= data

     const newApi = axios.create( {
      baseURL: url,
      headers: {
        Application:'Access-Control-Allow-Origin',
      }})

      await newApi.post(`/registration`, {
        userName,
        email,
        password,
      })
      .then((res) => {
        console.log(res)
        alert("The account was successfully registered!")
        navigate("/")
        setLoadingScreen(false)
        

      }).catch((error) => {
        console.log(error)
        alert('ERROR REGISTER!',error)
        setLoadingScreen(false)

      }).finally(() => {
      })
      
     
    }

  const registerUserFormSchema = Yup.object().shape({
    name: Yup.string().required(
      'name é obrigatório.'
    ),
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
    {resolver: yupResolver(registerUserFormSchema)}
   )

const submitForm = async (data) => {

  try {
    await tryRegisterUser(data);

  } catch (error) {
    console.log(error)
    setLoadingScreen(false)

    alert('ERROR!',error)
  }

}

  return (
    <C.Container>
      <C.Label>THE GOOD SEEDS</C.Label>
      <img src={logo}  style={{ width:100, height:100 }}  />

      <C.Content>
        
      <form onSubmit={handleSubmit(submitForm)} >

      <label htmlFor="name">name</label>
<input
id="name"
type="name"
placeholder="Your Name"
{...register('name')}
name='name'
/>
{errors.name && <span>{errors.name?.message}</span> }

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
  minLength="8" 
  pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^0-9a-zA-Z]).{8,26}$"
  title="Digite uma senha com 8 letras, 1 maiúscula e 1 caractére especial."
  x-moz-errormessage="Digite uma senha com 8 letras, 1 maiúscula e 1 caractére especial."
  placeholder="Your password"
  {...register('password')}
  name='password'
  />
{errors.password && <span>{errors.password?.message}</span> }

<span>{errorGlobal}</span>
<div style={{ padding:12, width:'100%'}} >

  {
    loadingScreen 
    ?
    <div style={{  width:'100%', justifyContent:'center', display:'flex',  }} >

    <TailSpin
      height="32"
      width="32"
      color="#4fa94d"
      ariaLabel="tail-spin-loading"
      radius="1"
      wrapperStyle={{ }}
      wrapperClass=""
      visible={true}
    />
    </div>
  :
<Button Text="Register" Type="submit"   />
  }

</div>


<C.LabelSignup>
  Already have an account?
  <C.Strong>
{
  !loadingScreen

  ? <Link to="/">&nbsp;Sign in</Link>
  :  <Link   onClick={ (event) => event.preventDefault() } style={{ cursor:'default' , }}   to="/">&nbsp;Log in</Link>
    }
  </C.Strong>

</C.LabelSignup>

</form> 
     
      </C.Content>
    </C.Container>
  );
};
