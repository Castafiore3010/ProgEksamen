package com.example.progeksamen.controller;

import com.example.progeksamen.model.Candidate;
import com.example.progeksamen.model.Election;
import com.example.progeksamen.model.Municipality;
import com.example.progeksamen.model.Party;
import com.example.progeksamen.repository.CandidateRepository;
import com.example.progeksamen.repository.ElectionRepository;
import com.example.progeksamen.repository.MunicipalityRepository;
import com.example.progeksamen.repository.PartyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;


import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CandidateController.class)
public class CandidateControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CandidateRepository candidateRepository;
    @MockBean
    private PartyRepository partyRepository;
    @MockBean
    private ElectionRepository electionRepository;
    @MockBean
    private MunicipalityRepository municipalityRepository;


    @Test
    public void mockService() throws Exception {
        Election kommunalValg2021 = new Election(null, 2021, "Kommunalvalg");
        electionRepository.save(kommunalValg2021);
        Municipality helsingørKommune = new Municipality(null, "Helsingør", 50660, 34738, kommunalValg2021);
        municipalityRepository.save(helsingørKommune);
        Party socialDemokratiet = new Party(null, "Socialdemokratiet", helsingørKommune, 8903);
        partyRepository.save(socialDemokratiet);
        Candidate candidate = new Candidate();
        candidate.setCandidateId(null);
        candidate.setFirstName("John");
        candidate.setLastName("Doe");
        candidate.setParty(socialDemokratiet);
        candidate.setPersonalVotes(2222);
        List<Candidate> allCandidates = Arrays.asList(candidate);

        given(candidateRepository.findAll()).willReturn(allCandidates);



        mvc.perform(get("/candidates")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].firstName").value(candidate.getFirstName()))
                .andExpect(jsonPath("$[0].lastName").value(candidate.getLastName()));
    }


}
