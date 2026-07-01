package saulo.brustolin.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import saulo.brustolin.api.dtos.users.UpdateUserDTO;
import saulo.brustolin.api.entities.User;
import saulo.brustolin.api.services.UserService;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    
    public final UserService userService;

    @PatchMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> update(@AuthenticationPrincipal User user, @RequestBody @Valid UpdateUserDTO dto) {
        userService.update(user, dto);

        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/send-code")
    public ResponseEntity<Void> sendCode(@AuthenticationPrincipal User user) {
        userService.sendCode(user);

        return ResponseEntity.ok().build();
    }
}
