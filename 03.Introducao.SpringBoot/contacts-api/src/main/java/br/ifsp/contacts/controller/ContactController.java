package br.ifsp.contacts.controller;

import br.ifsp.contacts.model.Contact;
import br.ifsp.contacts.repository.ContactRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Classe responsável por mapear as rotas/endpoints relacionados
 * aos contatos. Cada método abaixo corresponde a uma operação
 * em nosso sistema.
 *
 * @RestController: Indica que esta classe é um controlador
 *                  responsável por responder requisições REST.
 * @RequestMapping("/api/contacts"): Indica o caminho base.
 */
@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    /**
     * @Autowired permite que o Spring "injete" automaticamente
     * uma instância de ContactRepository aqui,
     * sem que precisemos criar manualmente.
     */
    @Autowired
    private ContactRepository contactRepository;

    /**
     * Método para obter todos os contatos.
     *
     * @GetMapping indica que este método vai responder a chamadas HTTP GET.
     * Exemplo de acesso: GET /api/contacts
     */
    @GetMapping
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    /**
     * Método para obter um contato específico pelo seu ID.
     *
     * @PathVariable "amarra" a variável {id} da URL
     * ao parâmetro do método.
     * Exemplo de acesso: GET /api/contacts/1
     */
    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable Long id) {
        // findById retorna um Optional, então usamos orElseThrow
        return contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado: " + id));
    }

    /**
     * Método para criar um novo contato.
     *
     * @PostMapping indica que este método responde a chamadas HTTP POST.
     * @RequestBody indica que o objeto Contact será preenchido
     * com os dados JSON enviados no corpo da requisição.
     */
    @PostMapping
    public Contact createContact(@Valid @RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    /**
     * Método para atualizar um contato existente.
     *
     * @PutMapping indica que este método responde a chamadas HTTP PUT.
     * Exemplo de acesso: PUT /api/contacts/1
     */
    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable Long id, @Valid @RequestBody Contact updatedContact) {
        // Buscar o contato existente
        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado: " + id));

        // Atualizar os campos
        existingContact.setNome(updatedContact.getNome());
        existingContact.setTelefone(updatedContact.getTelefone());
        existingContact.setEmail(updatedContact.getEmail());

        // Salvar alterações
        return contactRepository.save(existingContact);
    }

    @GetMapping("/search")
    public List<Contact> getContactsByName(@RequestParam("name") String contactName){
        return contactRepository.findByNomeContainingIgnoreCase(contactName);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Contact> updateContactFields(@PathVariable Long id, @Valid @RequestBody Contact updatedContact){
        Contact targetContact = contactRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if(updatedContact.getEmail() != null){
            targetContact.setEmail(updatedContact.getEmail());
        } else if (updatedContact.getNome() != null){
            targetContact.setNome(updatedContact.getNome());
        } else if (updatedContact.getTelefone() != null){
            targetContact.setTelefone(updatedContact.getTelefone());
        }

        return ResponseEntity.ok(targetContact);
    }

    /**
     * Método para excluir um contato pelo ID.
     *
     * @DeleteMapping indica que este método responde a chamadas HTTP DELETE.
     * Exemplo de acesso: DELETE /api/contacts/1
     */
    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactRepository.deleteById(id);
    }
}