import './App.css';
import Header from "./Header";
import {Box} from "@mui/material";
import Body from "./Body";

function App() {
  return (
      <div>
        <Header />
        <Box m={2} />
        <Body />
      </div>
  )
}

export default App;
