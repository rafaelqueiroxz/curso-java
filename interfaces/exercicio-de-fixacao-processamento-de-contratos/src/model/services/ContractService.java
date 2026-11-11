package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;


public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService (OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {

        double basicQuota = contract.getContractValue() / months;

        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getContractDate().plusMonths(i);

            double interest = onlinePaymentService.interest(basicQuota, i);
            double fee = onlinePaymentService.paymentFee(basicQuota + interest);

            double quota = basicQuota + interest + fee;

            contract.getInstallments().add(new Installment(dueDate, quota));
        }

    }

}
