import styled from 'styled-components';

export const ContainerButton = styled.button`
  width: ${(props) => props.largura}px ;
  height: ${(props) => props.altura }px ;
  min-width:80px ;
   font-size: 1rem;
    color: ${(props) => props.corTexto};
    background: ${(props) => props.cor};
    border: 0;
    padding: 0 16px;
    border-radius: 0.25rem;
    transition: filter 0.2s;
    cursor:pointer ;
    &:hover {
      filter: brightness(0.9);
    }
`;
