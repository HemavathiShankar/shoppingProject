/*
 * package com.example.gateway.controller;
 * 
 * 
 * import org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.security.core.annotation.AuthenticationPrincipal; import
 * org.springframework.security.oauth2.client.OAuth2AuthorizedClient; import
 * org.springframework.security.oauth2.client.annotation.
 * RegisteredOAuth2AuthorizedClient; import
 * org.springframework.security.oauth2.core.oidc.user.OidcUser; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.example.gateway.model.AuthenticationResponse;
 * 
 * @RestController
 * 
 * @RequestMapping("/authenticate") public class AuthenticationController {
 * 
 * @GetMapping("/login") public ResponseEntity<AuthenticationResponse>
 * login(@AuthenticationPrincipal OidcUser oidUser,Model model
 * , @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client){
 * 
 * AuthenticationResponse authenticationResponse=AuthenticationResponse.
 * builder().userId(oidUser.getEmail()).
 * accessToken(client.getAccessToken().getTokenValue()). //
 * refreshToken(client.getRefreshToken().getTokenValue()).
 * expiresAt(client.getAccessToken().getExpiresAt().getEpochSecond()).build();
 * return new ResponseEntity<>(authenticationResponse,HttpStatus.OK);
 * 
 * }
 * 
 * 
 * }
 */