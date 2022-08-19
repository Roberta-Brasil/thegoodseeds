import { AuthProvider } from "./contexts/auth";
import {AppRoute} from "./routes";
import { GlobalStyle } from "./styles/global.css";

function App() {
  return (
    <div  > 
  <AuthProvider>
    <AppRoute />
    <GlobalStyle />
  </AuthProvider>
    </div>
  );
}

export default App;
