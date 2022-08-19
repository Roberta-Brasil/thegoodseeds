import styled from "styled-components";

export const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  gap: 10px;
  height: 100vh;
  background-color:var(--secondary) ;
`;

export const Content = styled.div`
  gap: 8px;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  width: 100%;
  box-shadow: 0 1px 2px var(--primary);
  background-color: white;
  max-width: 350px;
  padding: 20px;
  border-radius: 5px;

input{
  /* outline: none; */
  padding: 16px 20px;
  width: 88%;
  border-radius: 5px;
  font-size: 16px;
  background-color: #e5e6e7;
  border: none;
}

  form {
    gap: 8px;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  width: 100%;
  }

  label{
    color:var(--primary);
    width:100% ;
  font-size: 14px;
  font-weight: 600;
  letter-spacing: 2px;
  font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
}

  span{
    color:red;
  font-size: 12px;
  font-weight: 600;
  letter-spacing: 2px;
  font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
}
`;

export const Label = styled.label`
  font-size: 18px;
  font-weight: 600;
  color: var(--white);
`;

export const LabelSignup = styled.label`
  font-size: 16px;
  color: var(--gray);
`;

export const labelError = styled.label`
  font-size: 14px;
  color: red;
`;

export const Strong = styled.strong`
  cursor: pointer;
  a {
    text-decoration: none;
    color: #676767;
  }
`;