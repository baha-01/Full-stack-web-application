import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Property } from '../models/Property';

@Injectable({
  providedIn: 'root'
})
export class PropertyServiceService {
  private apiUrl = "http://localhost:8087/api/property"
  constructor(private http:HttpClient) { }
  getAllProperties():Observable<Property[]> {
    return this.http.get<Property[]>(this.apiUrl)
  }
  getPropertyById(id:number):Observable<Property> {
    return this.http.get<Property>(`${this.apiUrl}/${id}`);
  }
  createProperty(property: Property): Observable<Property> {
    return this.http.post<Property>(this.apiUrl, property);
  }
  updateProperty(id: number, property: Property): Observable<Property> {
    return this.http.put<Property>(`${this.apiUrl}/${id}`, property);
  }
  deleteProperty(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
