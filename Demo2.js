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
  ScrollView,
} from "react-native";
import BDdVideoViewManager from "./BDdVideoViewManager";


var video_url = "http://101.201.68.107/热血沸腾!_国外跑酷玩家超能集锦!_标清.mp4";
var data = [];
var view = [];
for (var i = 0; i < 10; i++) {
  data.push({key: i, title: i + ''});
}
var ITEM_HEIGHT = 100;
export default class Demo2 extends Component {
  componentDidMount(){
    // this.timer = setTimeout(() => {
    //   NativeModules.BDVideoMoudle.pause()
    // }, 10000);
  }
//      clearTimeout(this.timer);
  componentWillUnmount(){
    clearTimeout(this.timer);


    NativeModules.BDVideoMoudle.release()
  }
  video;
  _renderItem = (item) => {
    // var txt = '第' + item.index + '个' + ' title=' + item.item.title;
    var txt = 'woshi' + item.index ;
    console.log('ssssssssssfvdvz+'+txt);
    var bgColor = item.index % 2 == 0 ? 'red' : 'blue';
    return  ( <View style={{height:100,width:"100%"}}><BDdVideoViewManager
      ref={(node) => view[item.index] = node}
      style={{width: '100%', height: '30%'}}>
    </BDdVideoViewManager>
      <Text style={{padding:10}} onPress={()=>{
        alert(122);
        view[item.index].setNativeProps({
        setCurrent:12000
      })}}>选中</Text>
      <Text style={{padding:10}} onPress={()=>view[item.index].setNativeProps({
        url:video_url,
        start:1
      })}>设置URL并开始</Text>
    </View>);
  }

  render() {
    return (
      <ScrollView contentContainerStyle={styles.container}>
        <View style={{
          width: '100%', height: 50, borderWidth: 2, borderColor: '#f00',
          justifyContent: 'center', alignItems: 'center',
        }}>
          <Text style={{textAlign: 'center',}}>百度视频测试（单位都是毫秒）</Text>
        </View>
        <FlatList
          style={{height:200,width:"100%"}}
          ref={(flatList)=>this._flatList = flatList}
          renderItem={this._renderItem}

          //numColumns ={3}
          //columnWrapperStyle={{borderWidth:2,borderColor:'black',paddingLeft:20}}

          //horizontal={true}

          //getItemLayout={(data,index)=>(
          //{length: ITEM_HEIGHT, offset: (ITEM_HEIGHT+2) * index, index}
          //)}

          //onEndReachedThreshold={5}
          //onEndReached={(info)=>{
          //console.warn(info.distanceFromEnd);
          //}}

          //onViewableItemsChanged={(info)=>{
          //console.warn(info);
          //}}
          data={data}>
        </FlatList>
        <BDdVideoViewManager
          ref="textInputRefer2"
          url={video_url}
          style={{width: '100%', height: '30%'}}>
        </BDdVideoViewManager>

        <View style={{flexDirection:'row'}}>
          <Text style={{padding:10}} onPress={()=> NativeModules.BDVideoMoudle.start()}>播放</Text>
          <Text style={{padding:10}} onPress={()=> NativeModules.BDVideoMoudle.pause()}>暂停</Text>
          <Text style={{padding:10}} onPress={()=>this.refs.textInputRefer2.setNativeProps({
            url:video_url,
            start:1
          })}>重置textInputRefer2</Text>
          <Text style={{padding:10}} onPress={()=> NativeModules.BDVideoMoudle.release()}>释放</Text>
        </View>
        <View style={{flexDirection:'row'}}>
          <Text style={{padding:10}} onPress={()=> NativeModules.BDVideoMoudle.getDuration((p)=>alert(p))}>视频长度</Text>
          <Text style={{padding:10}} onPress={()=> NativeModules.BDVideoMoudle.getCurrentPosition((p)=>alert(p))}>当前进度</Text>
          <Text style={{padding:10}} onPress={()=> NativeModules.BDVideoMoudle.getVideoLayout((width,height)=>alert(width+","+height))}>视频宽高</Text>
          <Text style={{padding:10}} onPress={()=> NativeModules.BDVideoMoudle.seekTo(20*1000)}>调整播放时间</Text>

        </View>

        <Text style={{padding:10}} onPress={()=> this.refs.textInputRefer2.setNativeProps({
          setCurrent:12000
        })
        }>切换当前View2（切换以后可以NativeModules控制）</Text>
      </ScrollView>
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