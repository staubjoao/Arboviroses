package br.com.api.controller;

import br.com.api.model.TipoImovel;
import br.com.api.service.impl.TipoImovelServiceImpl;
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
public class TipoImovelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TipoImovelServiceImpl tipoImovelService;

    @BeforeEach
    void setUp() {
        // Configure comportamento esperado para o serviço mock (tipoImovelService)
        TipoImovel tipoImovel = new TipoImovel(); // Configurar o objeto apropriado
        Mockito.when(tipoImovelService.salvar(Mockito.any(TipoImovel.class), Mockito.any(BindingResult.class)))
                .thenReturn(ResponseEntity.ok(new Response<TipoImovel>()));
    }

    @Test
    public void testPost() throws Exception {
        TipoImovel tipoImovel = new TipoImovel();
        tipoImovel.setId(1);
        tipoImovel.setSigla("01");
        tipoImovel.setDescricao("Casa");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/tipo_imovel")
                        .content(asJsonString(tipoImovel))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetAll() throws Exception {
        // Configurar o comportamento esperado para o serviço mock, se aplicável

        mockMvc.perform(MockMvcRequestBuilders.get("/api/tipo_imovel"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetById() throws Exception {
        // Configurar o comportamento esperado para o serviço mock, se aplicável

        mockMvc.perform(MockMvcRequestBuilders.get("/api/tipo_imovel/1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testPut() throws Exception {
        TipoImovel tipoImovel = new TipoImovel(); // Configurar o objeto apropriado

        mockMvc.perform(MockMvcRequestBuilders.put("/api/tipo_imovel")
                        .content(asJsonString(tipoImovel))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        // Configurar o comportamento esperado para o serviço mock, se aplicável

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/tipo_imovel/1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // Método de utilidade para converter objeto em JSON
    private static String asJsonString(final Object obj) {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
