import { NgModule } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';

import { ProductListComponent } from "../product-list/product-list.component";
import { BasketComponent } from "../basket/basket.component";
import { LoginFormComponent } from "../login-form/login-form.component";
import { AuthGuard } from '../auth.guard';


const routes: Routes = [
  {
    path: '',
    component: LoginFormComponent
  },
  {
    path: 'products',
    component: ProductListComponent
  },
  {
    path: 'basket',
    component: BasketComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'login',
    component: LoginFormComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: [],
})
export class RoutingModule { }
