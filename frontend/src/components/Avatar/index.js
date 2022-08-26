import React from 'react';
import {Image, ContainerAvatar} from './styles'
import useAuth from '../../hooks/useAuth';

export function Avatar({onClick}) {
  const { user } = useAuth()
  return (
   
    <ContainerAvatar onClick={onClick} >

    <Image
    src={user?.profileImg}
    alt="new"
    />

    <p>{user?.email}</p>
    </ContainerAvatar>

     
  )
}