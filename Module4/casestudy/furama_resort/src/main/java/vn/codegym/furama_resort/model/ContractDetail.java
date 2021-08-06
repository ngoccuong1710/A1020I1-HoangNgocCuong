package vn.codegym.furama_resort.model;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer contractDetailId;

    @ManyToOne
    @JoinColumn(name = "contractId", referencedColumnName = "contractId", nullable = false)
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attachServiceId", referencedColumnName = "attachServiceId", nullable = false)
    private AttachService attachService;

    private Integer quantity;

    public ContractDetail() {
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
