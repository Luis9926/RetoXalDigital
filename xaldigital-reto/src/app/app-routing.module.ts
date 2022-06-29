import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { StackoverflowComponent } from './section/stackoverflow/stackoverflow.component';
import { VuelosComponent } from './section/vuelos/vuelos.component';

const routes: Routes = [
  {path:'',component:MenuComponent},
  {path:'stackoverflow', component: StackoverflowComponent},
  {path:'vuelos', component: VuelosComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
