package com.greendata.bootstrap;

import com.greendata.domain.client.Company;
import com.greendata.domain.client.InterestStatus;
import com.greendata.domain.client.Investor;
import com.greendata.domain.installation.Installation;
import com.greendata.domain.installation.InstallationStatus;
import com.greendata.domain.installation.Quotation;
import com.greendata.services.InstallationService;
import com.greendata.services.InvestorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {

    InvestorService investorService;
    InstallationService installationService;

    public DataLoader(InvestorService investorService, InstallationService installationService) {
        this.investorService = investorService;
        this.installationService = installationService;
    }

    @Override
    public void run(String... args) throws Exception {
//        loadFirstClient();
//        loadSecondClient();
    }

    private void loadFirstClient() {
        Investor investor1 = new Investor();
        investor1.setFirstName("Tom");
        investor1.setLastName("Addams");
        investor1.setEmail("goracawoda@company.com");
        investor1.setPhoneNumber("876123090");
        investor1.setAddress("Krakow, Lubiszowa 8");
        investor1.setInterestStatus(InterestStatus.INTERESTED_BUT);
        investor1.setFirstVisit(LocalDate.of(2022, 1, 25));
        investor1.setAwaitedContact(LocalDate.of(2022, 9, 10));
        investor1.setComment("Musi przebudowac dach");
        investor1.setResponse("Czyli do 9.10 sie nie kontaktujemy?");

        Company company1 = new Company();
        company1.setAddress("Krakow, Lubiszowa 9");
        company1.setName("W goracej wodzie Company");

        Installation installation1 = new Installation();
        installation1.setInstallationStatus(InstallationStatus.ACCEPTED);
        installation1.setInstalledPower(50);
        installation1.setAddress("Krakow, Lubiszowa 9");
        installation1.setComment("50 na probe");
        installation1.setResponse("to drugie to na jego domek?");

        Quotation quotation1 = new Quotation();
        quotation1.setDescription("Pierwsza wycena");
        Quotation quotation2 = new Quotation();
        quotation2.setDescription("Druga ostateczna wycena");

        Installation installation2 = new Installation();
        installation2.setInstallationStatus(InstallationStatus.IN_PROGRESS);
        installation2.setInstalledPower(24);
        installation2.setAddress("Krakow, Lubiszowa 10");
        installation2.setComment("Materialy w drodze");

        Quotation quotation3 = new Quotation();
        quotation3.setDescription("Pierwsza wycena");
        Quotation quotation4 = new Quotation();
        quotation4.setDescription("Druga ostateczna wycena");

        investor1.setCompanies(new HashSet<>());
        investor1.setInstallations(new HashSet<>());
        investor1.setQuotations(new HashSet<>());
        installation1.setQuotations(new HashSet<>());
        installation2.setQuotations(new HashSet<>());

        investor1.getCompanies().add(company1);
        company1.setPersonInCharge(investor1);

        investor1.getInstallations().add(installation1);
        installation1.setInvestor(investor1);
        investor1.getInstallations().add(installation2);
        installation2.setInvestor(investor1);

        investor1.getQuotations().add(quotation1);
        quotation1.setInvestor(investor1);
        investor1.getQuotations().add(quotation2);
        quotation2.setInvestor(investor1);
        investor1.getQuotations().add(quotation3);
        quotation3.setInvestor(investor1);
        investor1.getQuotations().add(quotation4);
        quotation4.setInvestor(investor1);

        installation1.getQuotations().add(quotation1);
        quotation1.setInstallation(installation1);
        installation1.getQuotations().add(quotation2);
        quotation2.setInstallation(installation1);
        installation2.getQuotations().add(quotation3);
        quotation3.setInstallation(installation2);
        installation2.getQuotations().add(quotation4);
        quotation4.setInstallation(installation2);

        investorService.saveInvestor(investor1);
        installationService.saveInstallation(installation1);
        installationService.saveInstallation(installation2);
    }

    private void loadSecondClient() {
        Investor investor1 = new Investor();
        investor1.setFirstName("Jacek");
        investor1.setLastName("Kuznia");
        investor1.setEmail("stolarex@gmail.com");
        investor1.setPhoneNumber("123432145");
        investor1.setAddress("Przemyslow, Popardowa 4");
        investor1.setInterestStatus(InterestStatus.INTERESTED);
        investor1.setFirstVisit(LocalDate.of(2022, 6, 2));
        investor1.setAwaitedContact(LocalDate.of(2022, 10, 1));
        investor1.setComment("Chce robic jak najszybciej, prosi o kontakt pod koniec tygodnia");
        investor1.setResponse("Ktos z biura zadzwoni");

        Company company1 = new Company();
        company1.setAddress("Warszawa, Popielata 159/4");
        company1.setName("Stolarex");

        Installation installation1 = new Installation();
        installation1.setInstallationStatus(InstallationStatus.COMPLETED);
        installation1.setInstalledPower(155);
        installation1.setAddress("Warszawa, Popielata 159/4");
        installation1.setComment("Beda chcieli wiecej jesli ta sie sprawdzi");
        installation1.setResponse("Ok");


        Quotation quotation1 = new Quotation();
        quotation1.setDescription("Wycena promocyjna");
        Quotation quotation2 = new Quotation();
        quotation2.setDescription("Wycena po drugiej rozmowie");

        Installation installation2 = new Installation();
        installation2.setInstallationStatus(InstallationStatus.ACCEPTED);
        installation2.setInstalledPower(12);
        installation2.setAddress("Przemyslow, Popardowa 4");
        installation2.setComment("Domek dla wlasciciela stolarexu");
        installation2.setComment("Prosil zeby wyrobic sie do konca miesiaca bo potem wyjezdza na urlop i nikogo nie bedzie w domu");
        installation2.setResponse("Ekipa bedzie w srode u niego");


        Quotation quotation3 = new Quotation();
        quotation3.setDescription("Pierwsza wycena");
        Quotation quotation4 = new Quotation();
        quotation4.setDescription("Poprawka do poprzedniej wyceny");

        investor1.setCompanies(new HashSet<>());
        investor1.setInstallations(new HashSet<>());
        investor1.setQuotations(new HashSet<>());
        installation1.setQuotations(new HashSet<>());
        installation2.setQuotations(new HashSet<>());

        investor1.getCompanies().add(company1);
        company1.setPersonInCharge(investor1);

        investor1.getInstallations().add(installation1);
        installation1.setInvestor(investor1);
        investor1.getInstallations().add(installation2);
        installation2.setInvestor(investor1);

        investor1.getQuotations().add(quotation1);
        quotation1.setInvestor(investor1);
        investor1.getQuotations().add(quotation2);
        quotation2.setInvestor(investor1);
        investor1.getQuotations().add(quotation3);
        quotation3.setInvestor(investor1);
        investor1.getQuotations().add(quotation4);
        quotation4.setInvestor(investor1);

        installation1.getQuotations().add(quotation1);
        quotation1.setInstallation(installation1);
        installation1.getQuotations().add(quotation2);
        quotation2.setInstallation(installation1);
        installation2.getQuotations().add(quotation3);
        quotation3.setInstallation(installation2);
        installation2.getQuotations().add(quotation4);
        quotation4.setInstallation(installation2);

        investorService.saveInvestor(investor1);
        installationService.saveInstallation(installation1);
        installationService.saveInstallation(installation2);
    }
}
