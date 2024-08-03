import {HttpHeaders, HttpInterceptorFn} from '@angular/common/http';
import {TokenService} from "../token/token.service";
import {inject} from "@angular/core";

export const httpTokenInterceptor: HttpInterceptorFn = (req, next) => {
  let tokenService = inject(TokenService);
  const token = tokenService.token;

  if (token) {
    const clonedToken = req.clone({
      headers: new HttpHeaders({
        Authorization: 'Bearer ' + token,
      })
    });
    return next(clonedToken);
  }
  return next(req);
};
