import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class YoutubeService {
  playlist = [
    {id: 1, song: 'Céline Dion - Ashes (from the Deadpool 2 Motion Picture Soundtrack)'},
    {id: 2, song: 'Deadpool 2 - Take on Me'},
    {id: 3, song: 'Nelly - Just A Dream'},
    {id: 4, song: 'Eminem - Love The Way You Lie ft. Rihanna'},
    {id: 5, song: 'The Black Eyed Peas - Where Is The Love?'}
  ];
  constructor() { }

  find(id: number) {
    return this.playlist.find(item => item.id == id);
  }
}
