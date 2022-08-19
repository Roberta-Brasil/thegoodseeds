import React from 'react';
import {Image, ContainerAvatar} from './styles'
import useAuth from '../../hooks/useAuth';

export function Avatar({onClick}) {
  const { user } = useAuth()

  return (
    console.log(user),
    <ContainerAvatar onClick={onClick} >

    <Image
    src="https://images.pexels.com/photos/20787/pexels-photo.jpg?auto=compress&cs=tinysrgb&h=350"
    alt="new"
    />

    <p>{user.name}</p>
    </ContainerAvatar>

     
  )
}