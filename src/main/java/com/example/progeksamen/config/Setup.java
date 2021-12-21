package com.example.progeksamen.config;


import com.example.progeksamen.model.Candidate;
import com.example.progeksamen.model.Election;
import com.example.progeksamen.model.Municipality;
import com.example.progeksamen.model.Party;
import com.example.progeksamen.repository.CandidateRepository;
import com.example.progeksamen.repository.ElectionRepository;
import com.example.progeksamen.repository.MunicipalityRepository;
import com.example.progeksamen.repository.PartyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class Setup implements CommandLineRunner {

    PartyRepository partyRepository;
    CandidateRepository candidateRepository;
    MunicipalityRepository municipalityRepository;
    ElectionRepository electionRepository;

    public Setup(PartyRepository partyRepository, CandidateRepository candidateRepository,
                 MunicipalityRepository municipalityRepository, ElectionRepository electionRepository) {
        this.partyRepository = partyRepository;
        this.candidateRepository = candidateRepository;
        this.municipalityRepository = municipalityRepository;
        this.electionRepository = electionRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        // Data for Helsingør kommune
        // https://www.helsingor.dk/demokrati/valg/fakta-om-valg/kandidatlister-og-valgforbund/
        // https://www.kmdvalg.dk

        Election kommunalValg2021 = new Election(null, 2021, "Kommunalvalg");
        electionRepository.save(kommunalValg2021);


        Municipality helsingørKommune = new Municipality(null, "Helsingør", 50660, 34738, kommunalValg2021);
        municipalityRepository.save(helsingørKommune);



        //List A

        //party
        Party socialDemokratiet = new Party(null, "Socialdemokratiet", helsingørKommune, 8903);
        //candidates
        Candidate candidate1 = new Candidate(null, "Claus", "Christoffersen", socialDemokratiet, 1822);
        Candidate candidate2 = new Candidate(null, "Thomas", "Horn", socialDemokratiet, 1003);
        Candidate candidate3 = new Candidate(null, "Gitte", "Kondrup", socialDemokratiet, 593);
        Candidate candidate4 = new Candidate(null, "Peter", "Poulsen", socialDemokratiet, 373);
        Candidate candidate5 = new Candidate(null, "Lone Grønhøj", "Frandsen", socialDemokratiet, 290);
        Candidate candidate6 = new Candidate(null, "Betina", "Svinggaard", socialDemokratiet, 482);
        Candidate candidate7 = new Candidate(null, "Lene", "Lindberg", socialDemokratiet, 339);
        Candidate candidate8 = new Candidate(null, "Silas", "Drejer", socialDemokratiet, 382);
        Candidate candidate9 = new Candidate(null, "Daniel Boalth", "Petersen", socialDemokratiet, 333);
        Candidate candidate10 = new Candidate(null, "Christian", "Thelin", socialDemokratiet, 134);
        Candidate candidate0 = new Candidate(null, "Lars", "Røsenørn-Dohn", socialDemokratiet, 25);
        Candidate candidate11= new Candidate(null, "Palle", "Wørman", socialDemokratiet, 212);
        Candidate candidate12 = new Candidate(null, "Harun", "Avdal", socialDemokratiet, 460);
        Candidate candidate13 = new Candidate(null, "Thomas Hjalmar", "Mikkelsen", socialDemokratiet, 52);
        Candidate candidate14 = new Candidate(null, "Jørgen", "Persson", socialDemokratiet, 24);
        Candidate candidate15 = new Candidate(null, "Mads", "Sandholdt", socialDemokratiet, 22);

        List<Candidate> candidateListA = new ArrayList<>();
        candidateListA.add(candidate1);
        candidateListA.add(candidate2);
        candidateListA.add(candidate3);
        candidateListA.add(candidate4);
        candidateListA.add(candidate5);
        candidateListA.add(candidate6);
        candidateListA.add(candidate7);
        candidateListA.add(candidate8);
        candidateListA.add(candidate9);
        candidateListA.add(candidate10);
        candidateListA.add(candidate0);
        candidateListA.add(candidate11);
        candidateListA.add(candidate12);
        candidateListA.add(candidate13);
        candidateListA.add(candidate14);
        candidateListA.add(candidate15);
        socialDemokratiet.setCandidates(candidateListA);

        partyRepository.save(socialDemokratiet);
        candidateRepository.saveAll(candidateListA);


        //List B

        //party
        Party radikaleVenstre = new Party(null, "Radikale Venstre", helsingørKommune, 2298);
        //candidates
        Candidate candidate16 = new Candidate(null, "Christian Holm", "Donatzky", radikaleVenstre, 927);
        Candidate candidate17 = new Candidate(null, "Knud", "Mogensen", radikaleVenstre, 131);
        Candidate candidate18 = new Candidate(null, "Birgit", "Mørup", radikaleVenstre, 248);
        Candidate candidate19 = new Candidate(null, "Per Frank", "Povlsen", radikaleVenstre, 37);
        Candidate candidate20 = new Candidate(null, "Inge-Lise", "Candelaria", radikaleVenstre, 62);
        Candidate candidate21 = new Candidate(null, "Morgens Aarsleff", "Hansen", radikaleVenstre, 26);
        Candidate candidate22 = new Candidate(null, "Niels", "Frederiksen", radikaleVenstre, 21);
        Candidate candidate23 = new Candidate(null, "Annette", "Steglich-Petersen", radikaleVenstre, 87);
        Candidate candidate24 = new Candidate(null, "Noah", "Nevado", radikaleVenstre, 32);
        Candidate candidate25 = new Candidate(null, "Hanne E.", "Jakobsen", radikaleVenstre, 80);
        Candidate candidate26 = new Candidate(null, "Poul Bernt", "Jensen", radikaleVenstre, 12);
        List<Candidate> candidateListB = new ArrayList<>();
        candidateListB.add(candidate16);
        candidateListB.add(candidate17);
        candidateListB.add(candidate18);
        candidateListB.add(candidate19);
        candidateListB.add(candidate20);
        candidateListB.add(candidate21);
        candidateListB.add(candidate22);
        candidateListB.add(candidate23);
        candidateListB.add(candidate24);
        candidateListB.add(candidate25);
        candidateListB.add(candidate26);
        radikaleVenstre.setCandidates(candidateListB);

        partyRepository.save(radikaleVenstre);
        candidateRepository.saveAll(candidateListB);


        //List C

        //party
        Party detKonservativeFolkeparti = new Party(null, "Det Konservative Folkeparti", helsingørKommune, 11875);

        //candiates
        Candidate candidate27 = new Candidate(null, "Benedikte", "Kiær", detKonservativeFolkeparti, 6002);
        Candidate candidate28 = new Candidate(null, "Jens", "Bertram", detKonservativeFolkeparti, 406);
        Candidate candidate29 = new Candidate(null, "Michael", "Mathiesen", detKonservativeFolkeparti, 426);
        Candidate candidate30 = new Candidate(null, "Birgitte", "Bergman", detKonservativeFolkeparti, 504);
        Candidate candidate31 = new Candidate(null, "Janus", "Kyhl", detKonservativeFolkeparti, 312);
        Candidate candidate32 = new Candidate(null, "Arne Thorvald", "Koktvedgaard", detKonservativeFolkeparti, 24);
        Candidate candidate33 = new Candidate(null, "Michael", "Lagoni", detKonservativeFolkeparti, 359);
        Candidate candidate34 = new Candidate(null, "Kristina", "Kongsted", detKonservativeFolkeparti,173);
        Candidate candidate35 = new Candidate(null, "Thomas", "Kok", detKonservativeFolkeparti, 282);
        Candidate candidate36 = new Candidate(null, "Gert", "Dyekjær", detKonservativeFolkeparti, 195);
        Candidate candidate37 = new Candidate(null, "Birgitte", "Milling", detKonservativeFolkeparti, 63);
        Candidate candidate38 = new Candidate(null, "CLaus", "Birkelyng", detKonservativeFolkeparti, 224);
        Candidate candidate39 = new Candidate(null, "Carol", "Krogstrup", detKonservativeFolkeparti, 63);
        Candidate candidate40 = new Candidate(null, "Tom", "Pedersen", detKonservativeFolkeparti, 163);
        Candidate candidate41 = new Candidate(null, "Olav", "Berntsen", detKonservativeFolkeparti, 113);
        Candidate candidate42 = new Candidate(null, "Henrik", "Malmgreen", detKonservativeFolkeparti, 61);
        Candidate candidate43 = new Candidate(null, "Henrik", "Carmel", detKonservativeFolkeparti, 99);
        Candidate candidate44 = new Candidate(null, "Thomas", "Grauslund", detKonservativeFolkeparti, 78);
        Candidate candidate45 = new Candidate(null, "Sarah Thorning", "Guldborg", detKonservativeFolkeparti, 146);
        Candidate candidate46 = new Candidate(null, "Knud Vinther", "Hansen", detKonservativeFolkeparti, 246);
        Candidate candidate47 = new Candidate(null, "Hanne", "Buur", detKonservativeFolkeparti, 4);
        Candidate candidate48 = new Candidate(null, "Steen", "Boldsen", detKonservativeFolkeparti, 192);
        Candidate candidate49 = new Candidate(null, "Per E.", "Thomsen", detKonservativeFolkeparti, 32);
        List<Candidate> candidateListC = new ArrayList<>();
        candidateListC.add(candidate27);
        candidateListC.add(candidate28);
        candidateListC.add(candidate29);
        candidateListC.add(candidate30);
        candidateListC.add(candidate31);
        candidateListC.add(candidate32);
        candidateListC.add(candidate33);
        candidateListC.add(candidate34);
        candidateListC.add(candidate35);
        candidateListC.add(candidate36);
        candidateListC.add(candidate37);
        candidateListC.add(candidate38);
        candidateListC.add(candidate39);
        candidateListC.add(candidate40);
        candidateListC.add(candidate41);
        candidateListC.add(candidate42);
        candidateListC.add(candidate43);
        candidateListC.add(candidate44);
        candidateListC.add(candidate45);
        candidateListC.add(candidate46);
        candidateListC.add(candidate47);
        candidateListC.add(candidate48);
        candidateListC.add(candidate49);

        detKonservativeFolkeparti.setCandidates(candidateListC);

        partyRepository.save(detKonservativeFolkeparti);
        candidateRepository.saveAll(candidateListC);

        //List D

        Party nyeBorgerlige = new Party(null, "Nye Borgerlige", helsingørKommune, 2149);

        Candidate candidate50 = new Candidate(null, "Ulla", "Kokfelt",nyeBorgerlige, 757);
        Candidate candidate51 = new Candidate(null, "Rene", "Schibler",nyeBorgerlige, 76);
        Candidate candidate52 = new Candidate(null, "Denise", "Rostgaard",nyeBorgerlige, 375);
        Candidate candidate53 = new Candidate(null, "Kenneth", "Kure",nyeBorgerlige, 24);
        Candidate candidate54 = new Candidate(null, "Jeanne", "Højstrøm",nyeBorgerlige, 32);
        Candidate candidate55 = new Candidate(null, "Margith Marie", "Jensen",nyeBorgerlige, 15);
        Candidate candidate56 = new Candidate(null, "Per", "Olsen", nyeBorgerlige, 78);
        Candidate candidate57 = new Candidate(null, "Peter", "la Cour",nyeBorgerlige, 34);
        List<Candidate> candidateListD = new ArrayList<>();
        candidateListD.add(candidate50);
        candidateListD.add(candidate51);
        candidateListD.add(candidate52);
        candidateListD.add(candidate53);
        candidateListD.add(candidate54);
        candidateListD.add(candidate55);
        candidateListD.add(candidate56);
        candidateListD.add(candidate57);

        nyeBorgerlige.setCandidates(candidateListD);

        partyRepository.save(nyeBorgerlige);
        candidateRepository.saveAll(candidateListD);


        // List F

        Party socialistiskFolkeparti = new Party(null, "Socialistisk Folkeparti",helsingørKommune, 1736);

        Candidate candidate58 = new Candidate(null, "Bente Borg", "Donkin",socialistiskFolkeparti, 674);
        Candidate candidate59 = new Candidate(null, "Anders", "Wilsbech",socialistiskFolkeparti, 70);
        Candidate candidate60 = new Candidate(null, "Niels", "Mørup",socialistiskFolkeparti, 97);
        Candidate candidate61 = new Candidate(null, "Thorfinn", "Johansen",socialistiskFolkeparti, 44);
        Candidate candidate62 = new Candidate(null, "Dorthe Bjørn", "Andersen",socialistiskFolkeparti, 104);
        Candidate candidate63 = new Candidate(null, "Ole", "Bergman",socialistiskFolkeparti, 75);

        List<Candidate> candidateListF = new ArrayList<>();
        candidateListF.add(candidate58);
        candidateListF.add(candidate59);
        candidateListF.add(candidate60);
        candidateListF.add(candidate61);
        candidateListF.add(candidate62);
        candidateListF.add(candidate63);

        socialistiskFolkeparti.setCandidates(candidateListF);
        partyRepository.save(socialistiskFolkeparti);
        candidateRepository.saveAll(candidateListF);

        // List H

        Party projektTransparens = new Party(null, "Projekt Transparens", helsingørKommune, 10);

        Candidate candidate64 = new Candidate(null, "Jeppe", "Hauptmann", projektTransparens, 8);

        List<Candidate> candidateListH = new ArrayList<>();
        candidateListH.add(candidate64);


        projektTransparens.setCandidates(candidateListH);
        partyRepository.save(projektTransparens);
        candidateRepository.saveAll(candidateListH);

        // List I

        Party liberalAlliance = new Party(null, "Liberal Alliance", helsingørKommune, 431);

        Candidate candidate65 = new Candidate(null, "Nicholas Just","Villadsen" , liberalAlliance,121);
        Candidate candidate66 = new Candidate(null, "Kira", "Danholm", liberalAlliance,41);
        Candidate candidate67 = new Candidate(null, "Aishah", "Yatim", liberalAlliance,12);
        Candidate candidate68 = new Candidate(null, "Jan", "Ilum", liberalAlliance,8);
        Candidate candidate69 = new Candidate(null, "Claus Helge", "Nielsen", liberalAlliance,17);
        Candidate candidate70 = new Candidate(null, "Nicklas M.", "Danholm", liberalAlliance,8);
        List<Candidate> candidateListI = new ArrayList<>();

        candidateListI.add(candidate65);
        candidateListI.add(candidate66);
        candidateListI.add(candidate67);
        candidateListI.add(candidate68);
        candidateListI.add(candidate69);
        candidateListI.add(candidate70);

        liberalAlliance.setCandidates(candidateListI);

        partyRepository.save(liberalAlliance);
        candidateRepository.saveAll(candidateListI);

        // List J

        Party listeHansen = new Party(null, "Listehansen", helsingørKommune, 60);

        Candidate candidate71 = new Candidate(null, "Jimmy", "Jørgensen",listeHansen, 40);
        Candidate candidate72 = new Candidate(null, "Erban", "Jakobsen",listeHansen, 8);
        List<Candidate> candidateListJ = new ArrayList<>();

        candidateListJ.add(candidate71);
        candidateListJ.add(candidate72);

        listeHansen.setCandidates(candidateListJ);
        partyRepository.save(listeHansen);
        candidateRepository.saveAll(candidateListJ);


        // List O

        Party danskFolkeparti = new Party(null, "Dansk Folkeparti", helsingørKommune, 1602);

        Candidate candidate73 = new Candidate(null, "Malene", "Harpsøe", danskFolkeparti, 592);
        Candidate candidate74 = new Candidate(null, "Freja", "Södergran", danskFolkeparti, 204);
        Candidate candidate75 = new Candidate(null, "Rune Oliver", "Christensen", danskFolkeparti, 147);
        Candidate candidate76 = new Candidate(null, "Stefan", "Warburg", danskFolkeparti, 37);
        Candidate candidate77 = new Candidate(null, "Delvalle", "Villarroel", danskFolkeparti, 4);
        Candidate candidate78 = new Candidate(null, "Lotte", "Lehnerskjold", danskFolkeparti, 19);
        Candidate candidate79 = new Candidate(null, "Max", "Tranebæk", danskFolkeparti, 22);
        Candidate candidate80 = new Candidate(null, "Erik", "Warburg", danskFolkeparti, 5);
        Candidate candidate81 = new Candidate(null, "Betty", "Andersen", danskFolkeparti, 9);
        Candidate candidate82 = new Candidate(null, "Niels-Christian", "Kjeldsen", danskFolkeparti, 6);
        Candidate candidate83 = new Candidate(null, "Esther", "Warburg", danskFolkeparti, 4);
        Candidate candidate84 = new Candidate(null, "Torben", "Elleboe", danskFolkeparti, 10);
        Candidate candidate85 = new Candidate(null, "Randi", "Nielsen", danskFolkeparti, 10);
        Candidate candidate86 = new Candidate(null, "Viggo", "Pedersen", danskFolkeparti, 4);
        Candidate candidate87 = new Candidate(null, "Jens", "Kirkegaard", danskFolkeparti, 29);
        Candidate candidate88 = new Candidate(null, "Ib", "Kirkegaard", danskFolkeparti, 53);
        List<Candidate> candidateListO = new ArrayList<>();
        candidateListO.add(candidate73);
        candidateListO.add(candidate74);
        candidateListO.add(candidate75);
        candidateListO.add(candidate76);
        candidateListO.add(candidate77);
        candidateListO.add(candidate78);
        candidateListO.add(candidate79);
        candidateListO.add(candidate80);
        candidateListO.add(candidate81);
        candidateListO.add(candidate82);
        candidateListO.add(candidate83);
        candidateListO.add(candidate84);
        candidateListO.add(candidate85);
        candidateListO.add(candidate86);
        candidateListO.add(candidate87);
        candidateListO.add(candidate88);

        danskFolkeparti.setCandidates(candidateListO);
        partyRepository.save(danskFolkeparti);
        candidateRepository.saveAll(candidateListO);


        // List P

        Party bellaListen = new Party(null, "Bella Listen", helsingørKommune, 13);

        Candidate candidate89 = new Candidate(null, "Robert", "Christiansen", bellaListen, 9);
        List<Candidate> candidateListP = new ArrayList<>();

        candidateListP.add(candidate89);

        bellaListen.setCandidates(candidateListP);

        partyRepository.save(bellaListen);
        candidateRepository.saveAll(candidateListP);

        // List V

        Party venstre = new Party(null, "Venstre, Danmarks Liberale Parti", helsingørKommune, 1905);

        Candidate candidate90 = new Candidate(null, "Mette Lene", "Jensen", venstre, 787);
        Candidate candidate91 = new Candidate(null, "Kari", "Jørgensen", venstre, 79);
        Candidate candidate92 = new Candidate(null, "Morten", "Westergaard", venstre, 203);
        Candidate candidate93 = new Candidate(null, "Bjørn", "Cronquist", venstre, 50);
        Candidate candidate94 = new Candidate(null, "Helena B.", "Sanders", venstre, 68);
        Candidate candidate95 = new Candidate(null, "Christine S.", "Brun", venstre, 111);
        Candidate candidate96 = new Candidate(null, "Mikael Heibrock", "Sørensen", venstre, 8);
        Candidate candidate97 = new Candidate(null, "Freddy", "Jensen", venstre, 3);
        Candidate candidate98 = new Candidate(null, "Holger", "Søndergaard", venstre, 2);
        Candidate candidate99 = new Candidate(null, "Bettina", "Cronquist", venstre, 17);
        Candidate candidate100 = new Candidate(null, "Mads Jessen", "Jensen", venstre, 66);
        Candidate candidate101 = new Candidate(null, "Karin", "Andersen", venstre, 16);
        List<Candidate> candidateListV = new ArrayList<>();
        candidateListV.add(candidate90);
        candidateListV.add(candidate91);
        candidateListV.add(candidate92);
        candidateListV.add(candidate93);
        candidateListV.add(candidate94);
        candidateListV.add(candidate95);
        candidateListV.add(candidate96);
        candidateListV.add(candidate97);
        candidateListV.add(candidate98);
        candidateListV.add(candidate99);
        candidateListV.add(candidate100);
        candidateListV.add(candidate101);


        venstre.setCandidates(candidateListV);

        partyRepository.save(venstre);
        candidateRepository.saveAll(candidateListV);


        // List Ø

        Party enhedsListen = new Party(null, "Enhedslisten - De Rød-Grønne", helsingørKommune, 2386);

        Candidate candidate102 = new Candidate(null, "Allan Berg", "Mortensen", enhedsListen, 531);
        Candidate candidate103 = new Candidate(null, "Jørgen", "Bodilsen", enhedsListen, 120);
        Candidate candidate104 = new Candidate(null, "Malthe", "Jacobsen", enhedsListen, 329);
        Candidate candidate105 = new Candidate(null, "Annette", "Frøhling", enhedsListen, 141);
        Candidate candidate106 = new Candidate(null, "Karin Claudia", "Steinberg", enhedsListen, 58);
        Candidate candidate107 = new Candidate(null, "Suzanne", "Schytt", enhedsListen, 224);
        Candidate candidate108 = new Candidate(null, "Hans", "Kjærgaard", enhedsListen, 21);
        List<Candidate> candidateListØ = new ArrayList<>();
        candidateListØ.add(candidate102);
        candidateListØ.add(candidate103);
        candidateListØ.add(candidate104);
        candidateListØ.add(candidate105);
        candidateListØ.add(candidate106);
        candidateListØ.add(candidate107);
        candidateListØ.add(candidate108);

        enhedsListen.setCandidates(candidateListØ);

        partyRepository.save(enhedsListen);
        candidateRepository.saveAll(candidateListØ);


        // List Å

        Party alternativet = new Party(null, "Alternativet", helsingørKommune, 811);

        Candidate candidate109 = new Candidate(null, "Mette", "Skamris", alternativet,273);
        Candidate candidate110 = new Candidate(null, "Helene Liliendahl", "Brydensholt", alternativet,269);
        Candidate candidate111 = new Candidate(null, "Morten", "Greve", alternativet,108);

        List<Candidate> candidateListÅ = new ArrayList<>();
        candidateListÅ.add(candidate109);
        candidateListÅ.add(candidate110);
        candidateListÅ.add(candidate111);

        alternativet.setCandidates(candidateListÅ);

        partyRepository.save(alternativet);
        candidateRepository.saveAll(candidateListÅ);





















    }
}
