import styled from 'styled-components';

export const Image = styled.img`
border-radius:50px ;
width:40px ;
height:40px ;
border:1px solid var(--clean-light);
`;

export const ContainerAvatar = styled.button`
background-color:transparent;
border: none;
cursor:pointer ;
align-items:center ;
display:flex;
flex-direction: column;

transition: filter 0.2s;
    &:hover {
      filter: brightness(0.9);
    }

p {
  font-size:12px ;
  color:var(--clean-light);
  margin-top:3px;
}

`;
