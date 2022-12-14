import React, {useState} from "react";
import Button from "../../components/ButtonLogin";
import * as C from "./styles";
import { Link, useNavigate } from "react-router-dom";
import useAuth from "../../hooks/useAuth";
import axios from 'axios';

import * as Yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup'

import {useForm} from 'react-hook-form'
import logo from '../../assets/logo.jpeg';
import { url } from "../../services/url";
import { TailSpin } from "react-loader-spinner";


export const SignIn = () => {
  const {  setToken , setUser} = useAuth();
  const navigate = useNavigate();

  const [loadingScreen, setLoadingScreen] = useState(false);



  const loginUserFormSchema = Yup.object().shape({
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
      {resolver: yupResolver(loginUserFormSchema)}
     )

     async function sendEmailPasswordLoginToApi(
    {  email,
      password}
    ) {

      const newApi = axios.create({
        baseURL: url,
        headers: {
          Application:'Access-Control-Allow-Origin'
         }})

      await newApi.post(`/auth`, {
        email,
        password,
      }).then((res) => {
        const token = res.data.token
        passTokenToTryGetDatasProfile(token)
    
      }).catch ((data) => {
        console.log(data.response.data.error)
        alert(data.response.data.error)
        // alert(data.error)
      }) 
    }

     async function tryAuthLogin(data) {

       await sendEmailPasswordLoginToApi({
        email: data.email,
        password: data.password
      })

    }

    async function getDatasProfileFromApi(token) {

      const newApi = axios.create({
        baseURL: url,
        headers: {
          Authorization: `Bearer ${token}`,
          "Access-Control-Allow-Origin": "*",
        }})   

      await newApi.get(`/users/myprofile`)
      .then((res) => 
      {
        
        setToken(token)
        setUser(res.data)

        navigate("/dashboard");
        alert("The login was successfully!")
        setLoadingScreen(false)

      }).catch ((error)=>  {
        alert('ERROR LOGIN!',error)
        console.log('ERROR!',error)
        setLoadingScreen(false)


      }).finally(() => {
      })

    }

    async function tryGetDatasProfile(token) {
        await getDatasProfileFromApi(token)
      }

     async function passTokenToTryGetDatasProfile(token){
        try {
          await tryGetDatasProfile(token);
    
        } catch (error) {
          console.log(error)
          alert('ERROR!',error)
        }
      }

  
  const submitForm =  (data) => {
    // setUser({email:'williamteste@hotmail.com', password:'123' })
    // setToken('LOREMTOKEN')
    // navigate("/dashboard")
    // return
    try {
       tryAuthLogin(data);

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
      minLength="8" 
      pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^0-9a-zA-Z]).{8,26}$"
      type="password"
      placeholder="Your password"
      {...register('password')}
      title="Digite uma senha com 8 letras, 1 mai??scula e 1 caract??re especial."
      x-moz-errormessage="Digite uma senha com 8 letras, 1 mai??scula e 1 caract??re especial."
      name='password'
    />
    {errors.password && <span>{errors.password?.message}</span> }


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

        <Button Text="Log in" Type="submit"   />
        }
        </div>

        <C.LabelSignup>
         Do you have an account?
          <C.Strong>

          { !loadingScreen 
          ?
           <Link aria-disabled={loadingScreen} to="/sign-up">&nbsp;Register</Link>
:
           <Link  onClick={ (event) => event.preventDefault() } style={{ cursor:'default' , }}  aria-disabled={loadingScreen} to="/sign-up">&nbsp;Register</Link>
}
          
          </C.Strong>

        </C.LabelSignup>

        <C.LabelSignup>
          Forget your
          <C.Strong>

          { !loadingScreen 
          ?  <Link  to="/password">&nbsp;Password?</Link>

          :  <Link onClick={ (event) => event.preventDefault() } style={{ cursor:'default' , }} to="/password">&nbsp;Senha?</Link>
          }
          </C.Strong>

        </C.LabelSignup>

        </form> 

      </C.Content>
    </C.Container>
  );
};
