package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.ExpenseMapper;
import br.com.unifacef.ijb.models.dtos.ExpenseDTO;
import br.com.unifacef.ijb.models.entities.Expense;
import br.com.unifacef.ijb.repositories.ExpenseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Transactional
    public ExpenseDTO createExpense(ExpenseDTO expenseDTO) {
        Expense expense = ExpenseMapper.convertExpenseDTOIntoExpense(expenseDTO);
        expense = save(expense);
        return ExpenseMapper.convertExpenseIntoExpenseDTO(expense);
    }

    public List<ExpenseDTO> getAllExpenses() {
        return ExpenseMapper.convertListOfExpenseIntoListOfExpenseDTO(expenseRepository.findAll());
    }

    public ExpenseDTO getExpenseById(Integer id) {
        Expense expense = OptionalHelper.getOptionalEntity(expenseRepository.findById(id));
        return ExpenseMapper.convertExpenseIntoExpenseDTO(expense);
    }

    @Transactional
    public ExpenseDTO updateExpense(Integer id, ExpenseDTO expenseDTO) {
        Expense existingExpense = OptionalHelper.getOptionalEntity(expenseRepository.findById(id));

        ExpenseMapper.updateExpense(expenseDTO, existingExpense);
        Expense updatedExpense = expenseRepository.save(existingExpense);

        return ExpenseMapper.convertExpenseIntoExpenseDTO(updatedExpense);
    }

    @Transactional
    public void deleteExpense(Integer id) {
        Expense expense = OptionalHelper.getOptionalEntity(expenseRepository.findById(id));
        expenseRepository.delete(expense);
    }
}
