import React from 'react';
import { Container, SubContainer} from './styles';
import { Link } from 'react-router-dom';

export function Main({children}) {
  return (
  <Container>
    <SubContainer>

    {children}
    </SubContainer>
  </Container>
  )
}