package br.com.api.controller;

import br.com.api.model.AmostraLaboratorial;
import br.com.api.service.impl.AmostraLaboratorialServiceImpl;
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

@SpringBootTest
@AutoConfigureMockMvc
public class AmostraLaboratorialControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AmostraLaboratorialServiceImpl amostraLaboratorialService;

    @BeforeEach
    void setUp() {
        AmostraLaboratorial amostraLaboratorial = new AmostraLaboratorial(); 
        Mockito.when(amostraLaboratorialService.salvar(Mockito.any(AmostraLaboratorial.class), Mockito.any(BindingResult.class)))
                .thenReturn(ResponseEntity.ok(new Response<AmostraLaboratorial>()));
    }

    @Test
    public void testPost() throws Exception {
        AmostraLaboratorial amostraLaboratorial = new AmostraLaboratorial();
        amostraLaboratorial.setId(1);
        amostraLaboratorial.setNumeroAmostraInicial("01");
        amostraLaboratorial.setNumeroAmostraFinal("02");
        amostraLaboratorial.setQuantidadeTubitos(1);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/amostra_laboratorial")
                        .content(asJsonString(amostraLaboratorial))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetAll() throws Exception {
        // Configurar o comportamento esperado para o serviço mock, se aplicável

        mockMvc.perform(MockMvcRequestBuilders.get("/api/amostra_laboratorial"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetById() throws Exception {
        // Configurar o comportamento esperado para o serviço mock, se aplicável

        mockMvc.perform(MockMvcRequestBuilders.get("/api/amostra_laboratorial/1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testPut() throws Exception {
        AmostraLaboratorial amostraLaboratorial = new AmostraLaboratorial();
        mockMvc.perform(MockMvcRequestBuilders.put("/api/amostra_laboratorial")
                        .content(asJsonString(amostraLaboratorial))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        // Configurar o comportamento esperado para o serviço mock, se aplicável

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/amostra_laboratorial/1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    
    public static String asJsonString(AmostraLaboratorial amostraLaboratorial) {
        try {
            return new ObjectMapper().writeValueAsString(amostraLaboratorial);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
