/**
 * Created by Auser on 2017/5/4.
 */

import React, {Component} from "react";
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  ListView,
  TouchableOpacity,
  Image,
  ToastAndroid,
  NativeModules,
  FlatList,
} from "react-native";
import BDdVideoViewManager from "./BDdVideoViewManager";


var video_url = "http://101.201.68.107/热血沸腾!_国外跑酷玩家超能集锦!_标清.mp4";

export default class TXVIDEODemo extends Component {
  componentDidMount(){
    this.timer = setTimeout(() => {
      NativeModules.BDVideoMoudle.pause()
    }, 10000);
  }
//      clearTimeout(this.timer);
  componentWillUnmount(){
    clearTimeout(this.timer);
    NativeModules.BDVideoMoudle.release()
  }
  render() {
    return (
      <View style={styles.container}>
        <View style={{
          width: '100%', height: 50, borderWidth: 2, borderColor: '#f00',
          justifyContent: 'center', alignItems: 'center',
        }}>
          <Text style={{textAlign: 'center',}}>百度视频测试</Text>
        </View>

        <BDdVideoViewManager
          url={video_url}
          style={{width: '100%', height: '30%'}}>
        </BDdVideoViewManager>



      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});