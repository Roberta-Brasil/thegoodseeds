import React from 'react';
import { ContainerButton} from './styles';

export function Button({title='texto', onClick, largura = 160, cor="#8A2BE2" ,corTexto="#f6f7f8", altura=48, Type='button'}) {
  return (
    <ContainerButton type={Type} altura={altura} corTexto={corTexto} cor={cor} largura={largura}  onClick={onClick} >
      {title}
    </ContainerButton>
  )
}