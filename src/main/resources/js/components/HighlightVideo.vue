<template>
    <div>
        <div class="flex justify-center video-container">
            <iframe width="853" height="480" :src="`https://www.youtube.com/embed/${ highlight_key }`" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
        </div>

        <div class="scrolling-wrapper">
            <div v-for="video in videos" class="card w-56 py-6 px-3" >
                <a :title="video.title" >
                    <img class="hover:grow hover:shadow-lg" @click="showcase($event)" :id="video.video_key" :src="`https://img.youtube.com/vi/${video.video_key}/maxresdefault.jpg`">
                </a>
            </div>
        </div>
    </div>

</template>

<script>
    export default {
        name: "VideoTiles",

        props: ['highlight_key', 'cat_id'],

        data() {
            return {
                videos: [],
                isActive: null
            }
        },

        mounted: function () {

            axios.post('/load-videos', {id:this.cat_id}).then(response => {
                let newData = [];

                if(response.data.length !== 0 ){
                    for (let i = 0; i < response.data.length; i++){
                        newData.push(response.data[i]);
                    }
                }

                this.videos = this.videos.concat(newData);

            });
        },

        methods: {

            showcase() {

                console.log("hello");
                var id = event.currentTarget.id;

                if (this.isActive == null){
                    document.getElementById(id).classList.toggle('isActive')
                    this.isActive = id
                } else {
                    document.getElementById(this.isActive).classList.toggle('isActive')
                    document.getElementById(id).classList.toggle('isActive')
                    this.isActive = id
                }

            }

        },
    }
</script>

<style scoped>

    .isActive{
        outline: red solid 5px;
    }

    .scrolling-wrapper {
        overflow-x: scroll;
        overflow-y: hidden;
        white-space: nowrap;
    }

    .card {
        display: inline-block;
    }

    .video-container {
        position: relative;
        padding-bottom: 56.25%;
        padding-top: 30px; height: 0; overflow: hidden;
    }

    .video-container iframe,
    .video-container object,
    .video-container embed {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
    }
</style>