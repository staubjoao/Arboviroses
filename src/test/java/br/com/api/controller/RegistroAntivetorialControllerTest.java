package br.com.api.controller;

import br.com.api.model.RegistroAntivetorial;
import br.com.api.service.impl.RegistroAntivetorialServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.com.api.responses.Response;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.validation.BindingResult;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.text.SimpleDateFormat;

@SpringBootTest
@AutoConfigureMockMvc
public class RegistroAntivetorialControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RegistroAntivetorialServiceImpl registroAntivetorialService;

    @BeforeEach
    void setUp() {
        RegistroAntivetorial registroAntivetorial = new RegistroAntivetorial(); 
        Mockito.when(registroAntivetorialService.salvar(Mockito.any(RegistroAntivetorial.class), Mockito.any(BindingResult.class)))
                .thenReturn(ResponseEntity.ok(new Response<RegistroAntivetorial>()));
    }

    @Test
    public void testPost() throws Exception {
        RegistroAntivetorial registroAntivetorial = new RegistroAntivetorial();
        registroAntivetorial.setId(1);
        // registroAntivetorial.setLocalidade("localidade");
        // registroAntivetorial.setRota("rota");
        registroAntivetorial.setDataAtividade("01/01/2021");
        registroAntivetorial.setHoraAtividade("12:00");
        registroAntivetorial.setNumMoradores(1);
        registroAntivetorial.setTipoVisita("tipoVisita");
        registroAntivetorial.setLarvasEncontradas(true);
        registroAntivetorial.setAcoes("acoes");
        registroAntivetorial.setTipoTratamentoFocal("tipoTratamentoFocal");
        registroAntivetorial.setQtdProdutoAplicado(1.0);
        registroAntivetorial.setTipoTratamentoPerifocal("tipoTratamentoPerifocal");
        registroAntivetorial.setQtdDepositosTratados(1);
        registroAntivetorial.setQtdCargasAplicadas(1);
        registroAntivetorial.setDepositosEliminados(true);
        registroAntivetorial.setObservacoes("observacoes");
        registroAntivetorial.setFotos(null);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/registro_antivetorial")
                        .content(asJsonString(registroAntivetorial))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetAll() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/registro_antivetorial"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetById() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/registro_antivetorial/1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testPut() throws Exception {
        RegistroAntivetorial registroAntivetorial = new RegistroAntivetorial();
        mockMvc.perform(MockMvcRequestBuilders.put("/api/registro_antivetorial")
                        .content(asJsonString(registroAntivetorial))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDelete() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/registro_antivetorial/1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    public static String asJsonString(RegistroAntivetorial registroAntivetorial) {
        try {
            return new ObjectMapper().writeValueAsString(registroAntivetorial);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
