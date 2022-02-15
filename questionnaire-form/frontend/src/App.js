import './App.css';
import Header from "./Header";
import {Box, createTheme, ThemeProvider} from "@mui/material";
import Body from "./Body";

const theme = createTheme({
    palette: {
        primary: {
            main: "#3949ab",
            light: "#6f74dd",
            dark: "#00227b"
        },
        secondary: {
            main: "#7986cb",
            light: "#aab6fe",
            dark: "#49599a"
        }
    }
})

function App(props) {
  return (
      <ThemeProvider theme={theme}>
        <Header />
        <Box m={2} />
        <Body mode={props.mode} />
      </ThemeProvider>
  )
}

export default App;
