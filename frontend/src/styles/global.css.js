import { createGlobalStyle } from "styled-components";

export const GlobalStyle = createGlobalStyle`
    :root {
    --white: #FFFFFF;
    --light: #f6f7f8;
    --gray: #676767;
    --primary: #172601;
    --secondary: #395908;
    --secondary-light: #789C32;
    --clean: #D9C873;
    --clean-light: #F2B56B;
    }
    * {
    margin: 0;
    padding: 0;
    }
`;