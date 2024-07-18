import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPropertyComponent } from './add-property/add-property.component';
import { ListPropertyComponent } from './list-property/list-property.component';
import { DetailPropertyComponent } from './detail-property/detail-property.component';
import { UpdatePropertyComponent } from './update-property/update-property.component';
import { ListPropertyAdminComponent } from './list-property-admin/list-property-admin.component';
import { DetailPropertyAdminComponent } from './detail-property-admin/detail-property-admin.component';

const routes: Routes = [
  //{ path: '', redirectTo: '/properties', pathMatch: 'full' },
  //{ path: 'properties', component: PropertyListComponent },
  {path : '', redirectTo: '/property', pathMatch: 'full'},
  { path: 'property/add', component: AddPropertyComponent },
  { path: 'property', component: ListPropertyComponent },
  {path: 'property/:id',component:DetailPropertyComponent},
  {path: 'admin/property/:id',component:DetailPropertyAdminComponent},
  {path: 'update-property/:id',component:UpdatePropertyComponent},
  {path: 'admin/property',component:ListPropertyAdminComponent},
  {path : '**', component: ListPropertyComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
