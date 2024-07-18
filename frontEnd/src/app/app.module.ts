import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AddPropertyComponent } from './add-property/add-property.component';
import { ListPropertyComponent } from './list-property/list-property.component';
import { DetailPropertyComponent } from './detail-property/detail-property.component';
import { UpdatePropertyComponent } from './update-property/update-property.component';
import { ListPropertyAdminComponent } from './list-property-admin/list-property-admin.component';
import { DetailPropertyAdminComponent } from './detail-property-admin/detail-property-admin.component';

@NgModule({
  declarations: [
    AppComponent,
    AddPropertyComponent,
    ListPropertyComponent,
    DetailPropertyComponent,
    UpdatePropertyComponent,
    ListPropertyAdminComponent,
    DetailPropertyAdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
