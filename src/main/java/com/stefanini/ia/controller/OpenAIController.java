package com.stefanini.ia.controller;

import com.stefanini.ia.model.Livro;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ai.chat.client.ChatClient;

// Responsavel por se comunicar com usuário e o openai
@RestController
@RequestMapping("/openai")
public class OpenAIController {

    private final OpenAiChatModel chatModel;

    public OpenAIController(OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/piada")
    public String gerarPiada(@RequestParam (value = "tema") String tema) {
        String prompt = "Gere uma piada sobre esse tema: " + tema;
        String resultadoPiada = chatModel.call(prompt);
        return resultadoPiada;
    }

    @GetMapping("/filme")
    public  String listarFilmes(@RequestParam (value = "categoria") String categoria) {
        String prompt = "Gere uma lista de 5 filmes com essa categoria: " + categoria;
        return chatModel.call(prompt);
    }

    @GetMapping("/musica")
    public String listarMusicas(@RequestParam (value = "genero") String genero) {
        PromptTemplate promptTemplate = new PromptTemplate("Gere uma lista de 5 livros com esse genero {genero}");
        promptTemplate.add("genero", genero);
        return chatModel.call(promptTemplate.create()).getResult().getOutput().getContent();
    }

    @GetMapping("resumo/livro/outputconverter")
    public  String resumirLivro(@RequestParam (value = "nome") String nome) {
        BeanOutputConverter<Livro> outputLivro = new BeanOutputConverter<>(Livro.class);
        PromptTemplate promptTemplate = new PromptTemplate("Gere um resumo do livro {nome}. A resposta deve conter" +
                " nome, autor, genero e resumo. {formato} . A resposta deve ser em português.");
        promptTemplate.add("nome", nome);
        promptTemplate.add("formato", outputLivro.getFormat());

        return chatModel.call(promptTemplate.create()).getResult().getOutput().getContent();
    }

    @GetMapping("resumo/livro/chatclient")
    public  Livro resumirLivro2(@RequestParam (value = "nome") String nome) {
        String prompt = "Gere um resumo do livro " + nome + " . A resposta deve conter" +
                " nome, autor, genero e resumo. A resposta deve ser em português.";
        return ChatClient.create(chatModel).prompt().user(prompt).call().entity(Livro.class);
    }

    @GetMapping("/resumo/livro/categoria")
    public Livro resumiLivroPorCategoria(@RequestParam String categoria){
        String promptTemplateBuilder = "Forneça-me o melhor livro para a " +
                categoria +
                ".\nForneça também um resumo do livro, as informações devem ser limitada e pouco aprofundada." +
                "\nA resposta deve conter esta informação: categoria, livro, ano, resenha, autor, resumo\n" +
                "\nA resposta deve ser em portugues - pt-BR";

        return ChatClient.create(chatModel).prompt()
                .user(promptTemplateBuilder)
                .call()
                .entity(Livro.class);
    }

}
