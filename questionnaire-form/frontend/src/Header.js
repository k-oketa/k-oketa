import {AppBar, Box, Button, Container, Toolbar, Typography} from "@mui/material";
import {Emoji} from "emoji-mart";


export default function Header() {
    return (
        <Box sx={{ flexGrow: 1 }}>
            <AppBar position="static">
                <Container maxWidth="xl">
                    <Toolbar>
                        <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
                            Questionnaire Form
                        </Typography>
                        <Button color="inherit"><Emoji emoji="jigsaw" size={16} native />アンケートを作成</Button>
                        <Button color="inherit"><Emoji emoji="memo" size={16} native />アンケートに回答</Button>
                    </Toolbar>
                </Container>
            </AppBar>
        </Box>
    )
}