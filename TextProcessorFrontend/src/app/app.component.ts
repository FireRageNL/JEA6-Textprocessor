import {Component, OnInit} from '@angular/core';
import {TextService} from '../services/text.service';
import {TextModel} from '../model/TextModel';
import * as SockJS from 'sockjs-client';
import * as Stomp from 'stompjs';
import {SockModel} from '../model/SockModel';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent implements OnInit {
  private serverUrl = 'http://localhost:8080/socket';
  private stompClient;
  title = 'app';
  textModel = new TextModel(null, true, true, Math.random().toString(36).substring(2, 15) + Math.random().toString(36).substring(2, 15));
  amountOfWords = '';
  mostAmount = '';
  mostChar = '';
  constructor(private service: TextService) {
    this.initializeSocket();
  }
  ngOnInit(): void {
  }

  public sendText() {
    this.amountOfWords = '';
    this.mostAmount = '';
    this.mostChar = '';
    this.service.postText(this.textModel);
  }

  private initializeSocket() {
    const ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(ws);
    const that = this;
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe('/update/' + that.textModel.id, (message) => {
        if (message.body) {
          console.log(message.body);
          const mod: SockModel = JSON.parse(message.body);
            if (mod.type === 'Count') {
              that.amountOfWords = mod.value;
            }
            if (mod.type === 'Most') {
              that.mostAmount = mod.value;
              that.mostChar = mod.property;
            }
        }
      });
    });
  }
}
