package com.example.progeksamen.repo;

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
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CandidateRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    CandidateRepository candidateRepository;
    @Autowired
    PartyRepository partyRepository;
    @Autowired
    MunicipalityRepository municipalityRepository;
    @Autowired
    ElectionRepository electionRepository;

    @Test
    public void create() {
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


        entityManager.persist(candidate);
        entityManager.persist(socialDemokratiet);
        entityManager.flush();

        Candidate created = candidateRepository.findByFirstNameAndLastName("John", "Doe");


        List<Candidate> candidateList = candidateRepository.getCandidatesByPartyId(1L);


        assertThat(created.getFirstName()).isEqualTo(candidate.getFirstName());
        assertThat(created.getLastName()).isEqualTo(candidate.getLastName());

        assertThat(candidateList.get(0).getFirstName()).isEqualTo(created.getFirstName());


    }
}
